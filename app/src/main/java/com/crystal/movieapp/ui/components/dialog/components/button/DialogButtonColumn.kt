package com.crystal.movieapp.ui.components.dialog.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.crystal.movieapp.ui.components.buttons.PrimaryButton
import com.crystal.movieapp.ui.components.buttons.SecondaryBorderButton
import com.crystal.movieapp.ui.components.buttons.SecondaryButton
import com.crystal.movieapp.ui.components.buttons.UnderlinedTextButton
import com.crystal.movieapp.ui.models.dialog.DialogButton
import com.crystal.movieapp.ui.theme.Paddings

@Composable
fun DialogButtonColumn(
    buttons: List<DialogButton>?
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttons?.forEachIndexed { index, dialogButton ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(Paddings.large))
            }
            when (dialogButton) {
                is DialogButton.Primary -> {
                    PrimaryButton(
                        text = dialogButton.title,
                        leadingIconData = dialogButton.leadingIconData,
                    ) { dialogButton.action?.invoke()}
                }
                is DialogButton.Secondary -> {
                    SecondaryBorderButton(
                        text = dialogButton.title,
                        ) { dialogButton.action?.invoke()}
                }
                is DialogButton.SecondaryBorderless -> {
                    SecondaryButton(
                        text = dialogButton.title,
                        ) { dialogButton.action?.invoke()}
                }
                is DialogButton.UnderlinedText -> {
                    UnderlinedTextButton(
                        text = dialogButton.title,
                    ) { dialogButton.action?.invoke()}
                }
            }
        }

    }

}
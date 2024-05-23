package com.crystal.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.crystal.movieapp.R
import com.crystal.movieapp.ui.models.dialog.DialogButton
import com.crystal.movieapp.ui.models.dialog.DialogContent
import com.crystal.movieapp.ui.models.dialog.DialogText
import com.crystal.movieapp.ui.models.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    button: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = button
    )

}
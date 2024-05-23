package com.crystal.movieapp.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.crystal.movieapp.ui.components.dialog.components.button.DialogButtonColumn
import com.crystal.movieapp.ui.components.dialog.components.content.DialogContentWrapper
import com.crystal.movieapp.ui.components.dialog.components.title.DialogTitleWrapper
import com.crystal.movieapp.ui.models.dialog.DialogButton
import com.crystal.movieapp.ui.models.dialog.DialogContent
import com.crystal.movieapp.ui.models.dialog.DialogText
import com.crystal.movieapp.ui.models.dialog.DialogTitle
import com.crystal.movieapp.ui.theme.MovieAppTheme
import com.crystal.movieapp.ui.theme.Paddings

@Composable
fun BaseDialogPopup(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(Paddings.none),
        shape = MaterialTheme.shapes.large
    ) {
        Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
            dialogTitle?.let {
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(
                        start = Paddings.xlarge,
                        end = Paddings.xlarge,
                        bottom = Paddings.xlarge,
                    )
            ) {
                dialogContent?.let { DialogContentWrapper(it) }

                buttons?.let { DialogButtonColumn(it) }
            }
        }

    }
}


@Preview
@Composable
fun BaseDialogPopupPreview() {
    MovieAppTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent = DialogContent.Rating(
                DialogText.Rating("abcde", 8.2f)
            ),
            buttons = listOf(
                DialogButton.Primary("OK") {},
                DialogButton.Secondary("Cancel") {}
            )
        )

    }
}


@Preview
@Composable
fun BaseDialogPopupPreview2() {
    MovieAppTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Default("TITLE"),
            dialogContent = DialogContent.Default(
                DialogText.Default("abcde")
            ),
            buttons = listOf(
                DialogButton.Secondary("OK") {},
                DialogButton.UnderlinedText("Cancel") {}
            )
        )

    }
}




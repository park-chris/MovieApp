package com.crystal.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.crystal.movieapp.ui.models.dialog.DialogButton
import com.crystal.movieapp.ui.models.dialog.DialogContent
import com.crystal.movieapp.ui.models.dialog.DialogText
import com.crystal.movieapp.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Ration(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header("Rate your Score!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(movieName, rating)
        ),
        buttons = buttons
    )

}
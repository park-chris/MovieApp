package com.crystal.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.crystal.movieapp.ui.models.dialog.DialogButton
import com.crystal.movieapp.ui.theme.MovieAppTheme

@Preview
@Composable
fun AlertPreview() {
    MovieAppTheme {
        DialogPopup.Alert(title = "Title", bodyText = "blah blah blah", buttons = listOf(
            DialogButton.Primary("Okay"),
            DialogButton.Primary("Cancel"),
        ))
    }
}
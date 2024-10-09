package com.example.calculator.ui.theme

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Pink = Color(0xFFFF8888)
val Red = Color(0xFFFF5722)

@Composable
fun CalcButton(
    modifier: Modifier = Modifier,
    label: String = "",
    isOperation: Boolean = false,
    onClick: (String) -> Unit
) {
    Button(
        modifier = modifier
            .aspectRatio(1f)
            .padding(8.dp), // Aumenta o espaçamento entre botões
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isOperation) Pink else Red
        ),
        onClick = { onClick(label) }
    ) {
        Text(
            text = label,
            fontSize = 24.sp, // Aumenta o tamanho da fonte nos botões
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

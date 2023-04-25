package com.ahmetgur.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.ahmetgur.todocompose.ui.theme.HighPriorityColor
import com.ahmetgur.todocompose.ui.theme.LowPriorityColor
import com.ahmetgur.todocompose.ui.theme.MediumPriorityColor
import com.ahmetgur.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
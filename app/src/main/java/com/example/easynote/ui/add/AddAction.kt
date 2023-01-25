package com.example.easynote.ui.add

import com.example.easynote.util.Action

sealed class AddAction: Action {
    data class CreateBote(val insertId: Long): AddAction()
    data class EditNote(val editId: Int): AddAction()
}
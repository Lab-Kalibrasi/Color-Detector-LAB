package com.doctorblue.colordetector.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.doctorblue.colordetector.R
import com.doctorblue.colordetector.model.UserColor
import com.google.android.material.button.MaterialButton

class ColorDetailDialog(
    context: Context,
    private val color: UserColor,
    private val onRemove: (UserColor) -> Unit
) : Dialog(context) {

    private lateinit var view_color_preview: View;
    private lateinit var txt_rgb: TextView;
    private lateinit var txt_hex: TextView;
    private lateinit var txt_hsl: TextView;
    private lateinit var btn_cancel: MaterialButton;
    private lateinit var btn_remove_color: MaterialButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_color_detail)
        setTitle(context.resources.getString(R.string.your_color))

        view_color_preview = findViewById(R.id.view_color_preview)
        txt_rgb = findViewById(R.id.txt_rgb)
        txt_hex = findViewById(R.id.txt_hex)
        txt_hsl = findViewById(R.id.txt_hsl)
        btn_cancel = findViewById(R.id.btn_cancel)
        btn_remove_color = findViewById(R.id.btn_remove_color)

        view_color_preview.setBackgroundColor(Color.parseColor(color.hex))

        txt_rgb.text = ("RGB(${color.r}, ${color.g}, ${color.b})")
        txt_hex.text = ("Hex : ${color.hex}")
        txt_hsl.text = ("HSL(${color.h}, ${color.s}, ${color.l})")


        btn_cancel.setOnClickListener { dismiss() }

        btn_remove_color.setOnClickListener {
            onRemove(color)
            dismiss()
        }

    }
}
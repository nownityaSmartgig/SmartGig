package com.smartgig.tech.utils

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class CustomOutlineProvider : ViewOutlineProvider() {
    override fun getOutline(view: View? , outline: Outline?) {
        if (view != null) {
            outline?.setRect(0,0,view.width,view.height)
        }
    }

}
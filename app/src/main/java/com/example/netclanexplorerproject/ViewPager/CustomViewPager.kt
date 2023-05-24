package com.example.netclanexplorerproject.ViewPager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    private var disableSwipe = false

    fun setDisableSwipe(disable: Boolean) {
        this.disableSwipe = disable
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {

        if (this.disableSwipe) {
            return super.onTouchEvent(ev)
        }
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (this.disableSwipe) {
            return super.onInterceptTouchEvent(ev)
        }
        return false
    }
}

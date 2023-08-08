package com.example.showmsglib

import android.content.Context
import android.widget.Toast

object ShowMsg {
     fun showToast(context: Context,msg:String){
         Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
     }
}
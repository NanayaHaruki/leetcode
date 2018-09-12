package entity

import com.google.gson.annotations.Expose

class User {
    @Expose
    val args4:String="12"

    @Expose
    var age = 13;

    @Expose
    var age1 = 0
    get() {
        field = age+1
        return field
    }

    @Expose
    val list = listOf<Int>()
}

open class A(val id:Int,val name:String)
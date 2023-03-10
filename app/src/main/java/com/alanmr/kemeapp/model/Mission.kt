package com.alanmr.kemeapp.model

import java.util.*


class Mission {
    var _id: String = ""
    var title: String = ""
    var description: String = ""
    var image: String = ""
    var valid_until: Date = Calendar.getInstance().time
    var completed: Boolean = false
    var type: Number = 0
    var action: Number = 0
    var reward: Number = 0
}
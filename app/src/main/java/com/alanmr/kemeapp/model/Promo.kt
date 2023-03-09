package com.alanmr.kemeapp.model

import java.util.Calendar
import java.util.Date

class Promo {
    var _id: String = ""
    var title: String = ""
    var url: String = ""
    var image: String = ""
    var valid_until: Date = Calendar.getInstance().time
}
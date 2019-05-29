package com.example.viewmodeltest.model

import java.util.*

data class DataResult (val contacts : ArrayList<DataContacts>)

data class DataContacts (val phone : DataPhone)

data class DataPhone(val mobile : String)


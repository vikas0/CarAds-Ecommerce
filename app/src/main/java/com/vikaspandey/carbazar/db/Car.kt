/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vikaspandey.carbazar.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "car_table")
data class Car(
    @PrimaryKey var id: Int, var brand:String, var model:String, var year:Int, val price:Int, var images: String,var contactEmail:String = "developer@aigen.tech"
):Serializable { fun name() = "$ $brand  $model"
fun images() = images.split(",")
    fun imageMain()= images.split(",",limit = 1)
    fun description() = brand + model+"\n"+year+"\n"+ "\u20B9"+price





}
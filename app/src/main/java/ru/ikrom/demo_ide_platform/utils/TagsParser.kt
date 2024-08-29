package ru.ikrom.demo_ide_platform.utils

import com.google.gson.Gson
import ru.ikrom.demo_ide_platform.ui.items.TagUI

object TagsParser {
    fun getTagsList(text: String): List<TagUI>{
        return (Gson().fromJson(text, List::class.java) as List<String>).map { TagUI(it) }
    }

    fun toJsonString(tags: List<TagUI>): String {
        val tagsList = tags.map { it.text }
        return Gson().toJson(tagsList)
    }
}
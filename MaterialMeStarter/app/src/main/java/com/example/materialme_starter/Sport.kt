package com.example.materialme_starter

class Sport(title: String?, info: String?, imageResource: Int) {
    // Member variables representing the title and information about the sport.
    private var title: String? = title
    private var info: String? = info
    private val imageResource = imageResource

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    fun getTitle(): String? {
        return title
    }

    /**
     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    fun getInfo(): String? {
        return info
    }

    fun getImageResource(): Int {
        return imageResource
    }

}

package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.CitySpecials
import com.example.mycityapp.model.Cuisine
import com.example.mycityapp.model.Museums
import com.example.mycityapp.model.ReligiousSites

object dataSource {

    val categories = listOf(
        CityCategory("Cuisine", R.drawable.cuisine),
        CityCategory("Religious Sites", R.drawable.religious_sites),
        CityCategory("Museums", R.drawable.museums))

fun getCategoryDetails(categoryName: String?): List<CitySpecials> {
    val categoryDetails = mapOf(
        "Cuisine" to listOf(

            Cuisine(
                "Nihari",
                "A slow-cooked beef stew flavored with spices, traditionally eaten at breakfast.",
                R.drawable.nihari),
        Cuisine(
            "Siri Paye",
             "Made from the head and feet of a goat or cow, served in spicy gravy.",
             R.drawable.paye
        ),
        Cuisine(
            "Halwa Puri",
             "Famous Lahori breakfast combo of sweet halwa, fried puri, and spicy chickpeas.",
            R.drawable.halwa_puri),
        Cuisine(
             "Lahori Chargha",
             "Deep-fried whole chicken marinated in Lahori spices.",
            R.drawable.charga),
        Cuisine(
             "Biryani",
             "Spicy rice dish with meat, herbs, and fried onions.",
            R.drawable.biryani),
        Cuisine(
             "Chicken Karahi",
             "Tomato-based spicy chicken cooked in a wok with garlic and green chilies.",
            R.drawable.karahi),
        Cuisine(
             "Seekh Kebab",
             "Minced meat mixed with spices, molded onto skewers, and grilled.",
            R.drawable.seehk_kebab),
        Cuisine(
            "Lahori Fish",
            "Crispy fried river fish marinated in spicy gram flour mix.",
            R.drawable.fish)
        ),
        "Religious Sites" to listOf(
            ReligiousSites("Badshahi Mosque", "Built in 1673 by Emperor Aurangzeb, it's one of the largest mosques in the world.", R.drawable.badshahi_mosque),
            ReligiousSites("Data Darbar", "Shrine of the Sufi saint Ali Hujwiri, a major spiritual center.",R.drawable.data_darbar ),
            ReligiousSites("Wazir Khan Mosque", "17th-century mosque known for its exquisite tile work.", R.drawable.wazir_khan_mosque),
            ReligiousSites("Mazar-e-Iqbal", "Tomb of Allama Iqbal, the national poet of Pakistan.",R.drawable.mazar_e_iqbal ),
            ReligiousSites("Bibi Pak Daman", "Shrine believed to be resting place of female relatives of Prophet Muhammad.", R.drawable.bibi_pak_damna),
            ReligiousSites("Moti Masjid", "Moti Masjid, one of the \"Pearl Mosques\", is a 17th-century religious building located inside the Lahore Fort, Lahore, Punjab, Pakistan. It is a small, white marble structure built by Mughal emperor Jahangir and modified by the architects of Shah Jahan.", R.drawable.moti_masjid),
            ReligiousSites("Tomb of Jahangir", "Mughal emperor’s tomb set in beautiful gardens.", R.drawable.tomb_of_emperor_jahangir),
            ReligiousSites("Grand Jamia Masjid", "Grand Jamia Mosque Lahore is a mosque located in Bahria Town, Lahore, Pakistan. With a capacity of 70,000 worshippers, it is the third largest mosque in Pakistan and the fourteenth largest mosque in the world.[1]", R.drawable.grand_jamia_masjid)
        ),
        "Museums" to listOf(
            Museums("Lahore Museum", "Houses historical artifacts from Indus Valley to colonial era.", R.drawable.lahore_museum),
            Museums("Shakir Ali Museum", "Former residence and gallery of modern artist Shakir Ali.",R.drawable.shakir_ali_museum ),
            Museums("Fakir Khana Museum", "Private museum with manuscripts, paintings, and relics.",R.drawable.fakir_khana ),
            Museums("National History Museum", "Digital museum narrating Pakistan’s creation and independence.",R.drawable.national_history_museum ),
            Museums("Army Museum", "Military history museum with weapons, tanks, and war memorials.", R.drawable.army_museum),
            Museums("Javed Manzil", "The Javed Manzil or the Allama Iqbal Museum is a monument and museum in Lahore, Pakistan.[1] Muhammad Iqbal lived there for three years, and died there.[2] It was listed as a Tentative UNESCO site, and was protected under the Punjab Antiquities Act of 1975,[3] and declared a Pakistani national monument in 1977. In honour of Iqbal, a Pakistani national poet,[4] it was converted into a museum, inaugurated in December 1984.", R.drawable.javed_manzil),
            Museums("Tollinton Market", "Tollinton Market, now the Lahore City Heritage Museum, is a historic building located on Mall Road in Lahore. Originally built in 1864 to host the Punjab Exhibition, it later served as a market and is now a museum showcasing Lahore's cultural heritage. ", R.drawable.tollinton_market),
            Museums("Summit Minar, Lahore", "The Summit Minar is an obelisk-shaped structure built in the centre of Charing Cross, Mall Road in the city of Lahore, Punjab the province of Pakistan.[1] It was built to commemorate the second Islamic Summit Conference held in Lahore from 22 to 24 February 1974. It is located in front of WAPDA House and the Punjab Assembly Building.[", R.drawable.islamic_summit_minar)
        )
   )
    return categoryDetails[categoryName] ?: emptyList()
    }
}

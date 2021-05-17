package com.raquezha.heograpiya.models.area

class AreaRepository {
    private val records = mutableListOf<Province>()

    val all: Areas
        get() = Areas(records)

    fun insert(provinceName: String, cityMunicipality: MutableList<CityMunicipality>) {
        records += Province(
            province = provinceName,
            cityMuncipality = cityMunicipality
        )
    }
}

val areaRecord = AreaRepository().apply {
    insert(
        provinceName = "Albay",
        cityMunicipality = mutableListOf(
            "Legazpi City",
            "Ligao City",
            "Tabaco City",
            "Bacacay",
            "Camalig",
            "Daraga",
            "Guinobatan",
            "Jovellar",
            "Libon",
            "Malilipot",
            "Malinao",
            "Manito",
            "Oas",
            "Pio Duran",
            "Polangui",
            "Rapu-Rapu",
            "Santo Domingo",
            "Tiwi"
        ).toCityMunicipality()
    )
    insert(
        provinceName = "Camarines Norte",
        cityMunicipality = mutableListOf(
            "Basud",
            "Capalonga",
            "Daet",
            "Jose Panganiban",
            "Labo",
            "Mercedes",
            "Paracale",
            "San Lorenzo Ruiz",
            "San Vicente",
            "Santa Elena",
            "Vinzons",
            "Talisay"
        ).toCityMunicipality()
    )
    insert(
        provinceName = "Camarines Sur",
        cityMunicipality = mutableListOf(
            "Iriga City",
            "Naga City",
            "Nabua",
            "Baao",
            "Pili",
            "Calabanga",
            "Pasacao",
            "Tinambac",
            "Ragay",
            "Sagñay",
            "Tigaon",
            "Tinamabac",
            "Minalabac",
            "Milaor",
            "Canaman",
            "Magarao",
            "Pamplona",
            "Lupi",
            "Libmanan",
            "Lagonoy",
            "Goa",
            "Garchitorena",
            "Gainza",
            "Del Gallego",
            "Caramoan",
            "Camaligan",
            "Buhi",
            "Bombon",
            "Cabusa",
            "Balatan"
        ).toCityMunicipality()
    )
    insert(
        provinceName = "Masbate",
        cityMunicipality = mutableListOf(
            "Mabaste City",
            "Aroroy",
            "Baleno",
            "Balud",
            "Batuan",
            "Cataingan",
            "Cawayan",
            "Claveria",
            "Dimasalan",
            "Esperanza",
            "Mandaon",
            "Milagros",
            "Mobo",
            "Monreal",
            "Palanas",
            "Pio V. Corpuz",
            "Placer",
            "San Fernando",
            "San Jacinto",
            "San Pascual",
            "Uson"
        ).toCityMunicipality()
    )
    insert(
        provinceName = "Sorsogon",
        cityMunicipality = mutableListOf(
            "Bagamanoc",
            "Baras",
            "Bato",
            "Caramoran",
            "Gigmoto",
            "Pandan",
            "Panganiban",
            "San Adres",
            "San Miguel",
            "Viga",
        ).toCityMunicipality()
    )
    insert(
        provinceName = "Catanduanes",
        cityMunicipality = mutableListOf(
            "Barcelona",
            "Bulan",
            "Bulusan",
            "Casiguran",
            "Castilla",
            "Donsol",
            "Gubat",
            "Irosin",
            "Juban",
            "Magallanes",
            "Matnog",
            "Pilar",
            "Prieto Diaz",
            "Santa Magdalena"
        ).toCityMunicipality()
    )
}

fun MutableList<String>.toCityMunicipality(): MutableList<CityMunicipality> {
    return map {
        CityMunicipality(it)
    }.toMutableList()
}
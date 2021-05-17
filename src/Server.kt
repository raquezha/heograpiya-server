package com.raquezha

import com.raquezha.location.Location
import com.raquezha.location.Provinces
import com.raquezha.lottie.LottieFile
import com.raquezha.lottie.LottieFiles

val lottieFile by lazy { LottieFiles(lottieFileList) }

var lottieFile1: String = "https://assets8.lottiefiles.com/private_files/lf30_qn7ozwlo.json"
var lottieFile2: String = "https://assets7.lottiefiles.com/packages/lf20_t0mvxlwu.json"

var lottieFileList = mutableListOf(
    LottieFile(
        description = "file1",
        url = lottieFile1,
        active = true
    ),
    LottieFile(
        description = "file2",
        url= lottieFile2,
        active = false
    )
)

val location by lazy { Location(provinceWithLocation) }

val provinceWithLocation = mutableListOf(
    Provinces(
        province = "Albay",
        location = mutableListOf(
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
        )
    ),
    Provinces(
        province = "Camarines Norte",
        location = mutableListOf(
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
        )
    ),
    Provinces(
        province = "Camarines Sur",
        location = mutableListOf(
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
        )
    ),
    Provinces(
        province = "Masbate",
        location = mutableListOf(
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
        )
    ),
    Provinces(
        province =  "Sorsogon",
        location = mutableListOf(
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
        )
    ),
    Provinces(
        province = "Catanduanes",
        location = mutableListOf(
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
        )
    )
)



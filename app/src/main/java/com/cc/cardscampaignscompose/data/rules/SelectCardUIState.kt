package com.cc.cardscampaignscompose.data.rules

data class SelectCardUIState(
    val id: Int,
    val name: String,
    val type: String
)
val itemList = listOf(
    SelectCardUIState(
        1, "Axess", "Akbank"
    ),
    SelectCardUIState(
        2, "Axess Business", "Akbank"
    ),
    SelectCardUIState(
        3, "Axess Gold", "Akbank"
    ),
    SelectCardUIState(
        4, "Maximum", "İşBankası"
    ),
    SelectCardUIState(
        5, "Business", "İşBankası"
    ),
    SelectCardUIState(
        6, "Maximum Gold", "İşBankası"
    ),
    SelectCardUIState(
        7, "TEB Bonus", "TEB"
    ),
    SelectCardUIState(
        8, "TEB Business", "TEB"
    ),
    SelectCardUIState(
        9, "TEB Gold", "TEB"
    ),
    SelectCardUIState(
        10, "EnPara", "QNB"
    ),
)

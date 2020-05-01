use project3
db.dropDatabase()

use project3

db.createCollection('clubs')

db.createCollection('players')

db.clubs.insertOne({
		name: "Manchester City FC",
		country: "England",
		transferInvestments: 1638,
		value: 3808,
		revenue: 678,
		league: [2012, 2014, 2018, 2019]
})

db.players.insertMany([
		{
			name: "Kevin De Bruyne",
			club: "Manchester City FC",
			year: 2015,
			fee: 75
		},
		{
			name: "Riyad Mahrez",
			club: "Manchester City FC",
			year: 2018,
			fee: 68
		},
		{
			name: "Aymeric Laporte",
			club: "Manchester City FC",
			year: 2018,
			fee: 65	
		},
		{
			name: "Raheem Sterling",
			club: "Manchester City FC",
			year: 2015,
			fee: 63	
		},
		{
			name: "Benjamin Mendy",
			club: "Manchester City FC",
			year: 2017,
			fee: 58
		}
])

db.clubs.insertOne({
		name: "FC Barcelona",
		country: "Spain",
		transferInvestments: 1525,
		value: 4021,
		revenue: 824,
		league: [2010, 2011, 2013, 2015, 2016, 2018, 2019],
		UEFAChampionsLeague: [2011, 2015]
})

db.players.insertMany([
		{
			name: "Philippe Coutinho",
			club: "FC Barcelona",
			year: 2018,
			fee: 120
		},
		{
			name: "Ousmane Dembele",
			club: "FC Barcelona",
			year: 2017,
			fee: 105
		},
		{
			name: "Luis Suarez",
			club: "FC Barcelona",
			year: 2014,
			fee: 82
		}
])

db.clubs.insertOne({
		name: "Chelsea FC",
		country: "England",
		transferInvestments: 1428,
		value: 2576,
		revenue: 597,
		league: [2010, 2015, 2017],
		UEFAChampionsLeague: [2012],
		UEFAEuropaLeague: [2013, 2019]
})

db.players.insertOne({
			name: "Alvaro Morata",
			club: "Chelsea FC",
			year: 2017,
			fee: 66
})

db.clubs.insertOne({
		name: "Paris Saint-Germain FC",
		country: "France",
		transferInvestments: 1392,
		value: 1092,
		revenue: 646,
		league: [2013, 2014, 2015, 2016, 2018, 2019]
})

db.players.insertMany([
		{
			name: "Neymar",
			club: "Paris Saint-Germain FC",
			year: 2017,
			fee: 222
		},
		{
			name: "Kylian Mbappe",
			club: "Paris Saint-Germain FC",
			year: 2018,
			fee: 135
		},
		{
			name: "Edinson Cavani",
			club: "Paris Saint-Germain FC",
			year: 2013,
			fee: 65
		},
		{
			name: "Angel Di Maria",
			club: "Paris Saint-Germain FC",
			year: 2015,
			fee: 64
		}
])

db.clubs.insertOne({
		name: "Juventus FC",
		country: "Italy",
		transferInvestments: 1272,
		value: 1512,
		revenue: 480,
		league: [2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019]
})

db.players.insertMany([
		{
			name: "Cristiano Ronaldo",
			club: "Juventus FC",
			year: 2018,
			fee: 100
		},
		{
			name: "Gonzalo Higuain",
			club: "Juventus FC",
			year: 2016,
			fee: 90
		}
])

db.clubs.insertOne({
		name: "Machester United FC",
		country: "England",
		transferInvestments: 1265,
		value: 3808,
		revenue: 795,
		league: [2011, 2013],
		UEFAEuropaLeague: [2017]
})

db.players.insertMany([
		{
			name: "Paul Pogba",
			club: "Machester United FC",
			year: 2016,
			fee: 105
		},
		{
			name: "Romelu Lukaku",
			club: "Machester United FC",
			year: 2017,
			fee: 85
		},
		{
			name: "Fred",
			club: "Machester United FC",
			year: 2018,
			fee:59
		}
		
])

db.clubs.insertOne({
		name: "Real Madrid FC",
		country: "Spain",
		transferInvestments: 1236,
		value: 4239,
		revenue: 896,
		league: [2012, 2017],
		UEFAChampionsLeague: [2014, 2016, 2017, 2018]
})

db.players.insertMany([
		{
			name: "Gareth Bale",
			club: "Real Madrid FC",
			year: 2013,
			fee: 100
		},
		{
			name: "James Rodriguez",
			club: "Real Madrid FC",
			year: 2014,
			fee: 76
		}	
])

db.clubs.insertOne({
		name: "Club Atletico de Madrid",
		country: "Spain",
		transferInvestments: 1110,
		value: 953,
		revenue: 363,
		league: [2018, 2019],
		UEFAEuropaLeague: [2012, 2018]
})

db.clubs.insertOne({
		name: "Liverpool FC",
		country: "England",
		transferInvestments: 1075,
		value: 2183,
		revenue: 613,
		UEFAChampionsLeague: [2019]
})

db.players.insertMany([
		{
			name: "Virgil van Dijk",
			club: "Liverpool FC",
			year: 2018,
			fee: 85
		},
		{
			name: "Alisson",
			club: "Liverpool FC",
			year: 2018,
			fee: 63
		},
		{
			name: "Naby Keita",
			club: "Liverpool FC",
			year: 2018,
			fee: 60
		}
])

db.clubs.insertOne({
		name: "Internazionale Milano FC",
		country: "Italy",
		transferInvestments: 968,
		value: 672,
		revenue: 335,
		league: [2010],
		UEFAChampionsLeague: [2010]
})

db.clubs.insertOne({
		name: "AS Roma",
		country: "Italy",
		transferInvestments: 895,
		value: 622,
		revenue: 298
})

db.clubs.insertOne({
		name: "AC Milan",
		country: "Italy",
		transferInvestments: 853,
		value: 583,
		revenue: 248,
		league: [2011]
})

db.clubs.insertOne({
		name: "Arsenal FC",
		country: "England",
		transferInvestments: 830,
		value: 2267,
		revenue: 520
})

db.players.insertOne({
			name: "Pierre-Emerick Aubameyang",
			club: "Arsenal FC",
			year: 2018,
			fee: 64
})

db.clubs.insertOne({
		name: "Tottenham Hotspur FC",
		country: "England",
		transferInvestments: 763,
		value: 1624,
		revenue: 511
})

db.clubs.insertOne({
		name: "Everton FC",
		country: "England",
		transferInvestments: 752,
		value: 476,
		revenue: 252
})

db.clubs.insertOne({
		name: "FC Bayern Munich",
		country: "Germany",
		transferInvestments: 727,
		value: 3024,
		revenue: 751,
		league: [2010, 2013, 2014, 2015, 2016, 2017, 2018, 2019],
		UEFAChampionsLeague: [2013]
})

db.clubs.insertOne({
		name: "Borussia Dortmund",
		country: "Germany",
		transferInvestments: 702,
		value: 896,
		revenue: 379,
		league: [2011, 2012]
})

db.clubs.insertOne({
		name: "Napoli",
		country: "Italy",
		transferInvestments: 693,
		value: 471,
		revenue: 219
})

db.clubs.insertOne({
		name: "AS Monaco",
		country: "France",
		transferInvestments: 862,
		value: 61,
		revenue: 124,
		league: [2017]
})

db.players.insertOne({
			name: "Radamel Falco",
			club: "AS Monaco",
			year: 2013,
			fee: 60
})

db.clubs.insertOne({
		name: "Valencia CF",
		country: "Spain",
		transferInvestments: 611,
		value: 288,
		revenue: 186,
		league: [2018, 2019],
		UEFAEuropaLeague: [2012, 2018]
})

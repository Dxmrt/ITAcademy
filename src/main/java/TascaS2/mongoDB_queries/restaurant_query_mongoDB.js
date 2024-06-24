db.Restaurants.find()
db.Restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({}, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({}, { _id: 0, restaurant_id: 1, name: 1, borough: 1, "address.zipcode": 1 })
db.Restaurants.find({ borough: "Bronx" })
db.Restaurants.find({ borough: "Bronx" }).limit(5)
db.Restaurants.find({ borough: "Bronx" }).skip(5).limit(5)
db.Restaurants.find({ "grades.score": { $gt: 90 } })
db.Restaurants.find({ "grades.score": { $gt: 80, $lt: 100 } })
db.Restaurants.find({ "address.coord.1": { $lt: -95.754168 } })
db.Restaurants.find({ 
    cuisine: { $ne: "American" }, 
    "grades.score": { $gt: 70 }, 
    "address.coord.0": { $lt: -65.754168 } 
})
db.Restaurants.find({ 
    cuisine: { $ne: "American" }, 
    "grades.score": { $gt: 70 }, 
    "address.coord.0": { $lt: -65.754168 } 
})
db.Restaurants.find({ 
    cuisine: { $ne: "American" }, 
    "grades.grade": "A", 
    borough: { $ne: "Brooklyn" }
}).sort({ cuisine: -1 })
db.Restaurants.find({ name: { $regex: /^Wil/ } }, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({ name: { $regex: /ces$/ } }, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({ name: { $regex: /Reg/ } }, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({ borough: "Bronx", cuisine: { $in: ["American", "Chinese"] } })
db.Restaurants.find({ borough: { $in: ["Staten Island", "Queens", "Bronx", "Brooklyn"] } }, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({ borough: { $nin: ["Staten Island", "Queens", "Bronx", "Brooklyn"] } }, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({ "grades.score": { $not: { $gt: 10 } } }, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({ 
    $or: [
        { cuisine: { $ne: "American" }, cuisine: { $ne: "Chinese" } }, 
        { name: { $regex: /^Wil/ } }
    ]
}, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })
db.Restaurants.find({ 
    "grades.grade": "A", 
    "grades.score": 11, 
    "grades.date": ISODate("2014-08-11T00:00:00Z")
}, { _id: 0, restaurant_id: 1, name: 1, grades: 1 })
db.Restaurants.find({ 
    "grades.1.grade": "A", 
    "grades.1.score": 9, 
    "grades.1.date": ISODate("2014-08-11T00:00:00Z")
}, { _id: 0, restaurant_id: 1, name: 1, grades: 1 })
db.Restaurants.find({ 
    "address.coord.1": { $gt: 42, $lte: 52 }
}, { _id: 0, restaurant_id: 1, name: 1, address: 1, "address.coord": 1 })
db.Restaurants.find().sort({ name: 1 })
db.Restaurants.find().sort({ name: -1 })
db.Restaurants.find().sort({ cuisine: 1, borough: -1 })
db.Restaurants.find({ "address.street": { $exists: false } })


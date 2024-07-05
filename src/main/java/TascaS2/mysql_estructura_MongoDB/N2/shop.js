db.createCollection('shop', {validator: {$jsonSchema: {bsonType: 'object',title: 'shop',required: ['name','order','data','employee'],properties:{name:{bsonType: 'string'},order:{bsonType: 'object',title: 'object',required: ['order_id','product','client','date_time'],properties:{order_id:{bsonType: 'objectId'},product:{bsonType: 'object',title: 'object',required: ['product_id','pizza','burger','drinks'],properties:{product_id:{bsonType: 'objectId'},pizza:{bsonType: 'object',title: 'object',required: ['name','category','description','image','price'],properties:{name:{bsonType: 'string'},category:{bsonType: 'string'},description:{bsonType: 'string'},image:{bsonType: 'string'},price:{bsonType: 'double'}}},burger:{bsonType: 'object',title: 'object',required: ['name','category','description','image','price'],properties:{name:{bsonType: 'string'},category:{bsonType: 'string'},description:{bsonType: 'string'},image:{bsonType: 'string'},price:{bsonType: 'double'}}},drinks:{bsonType: 'object',title: 'object',required: ['name','category','description','image','price'],properties:{name:{bsonType: 'string'},category:{bsonType: 'string'},description:{bsonType: 'string'},image:{bsonType: 'string'},price:{bsonType: 'double'}}}}},client:{bsonType: 'object',title: 'object',required: ['client_id','name','order_type'],properties:{client_id:{bsonType: 'objectId'},name:{bsonType: 'string'},order_type:{bsonType: 'object',title: 'object',properties:{delivery:{bsonType: 'object',title: 'object',required: ['street','number','telephone','notes','driver'],properties:{street:{bsonType: 'string'},number:{bsonType: 'int'},floor:{bsonType: 'int'},telephone:{bsonType: 'string'},notes:{bsonType: 'string'},driver:{bsonType: 'string'}}},takeaway_ref:{bsonType: 'bool'}}}}},date_time:{bsonType: 'timestamp'}}},data:{bsonType: 'object',title: 'object',required: ['street','number','city','country'],properties:{street:{bsonType: 'string'},number:{bsonType: 'int'},floor:{bsonType: 'int'},city:{bsonType: 'string'},country:{bsonType: 'string'}}},employee:{bsonType: 'object',title: 'object',required: ['employee_id','name','surname','telephone','nif','assignment'],properties:{employee_id:{bsonType: 'objectId'},name:{bsonType: 'string'},surname:{bsonType: 'string'},telephone:{bsonType: 'string'},nif:{bsonType: 'string'},assignment:{bsonType: 'object',title: 'object',required: ['chef','driver'],properties:{chef:{bsonType: 'string'},driver:{bsonType: 'string'}}}}}}}}});
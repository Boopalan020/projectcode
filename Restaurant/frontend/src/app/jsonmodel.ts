export interface Jsonmodel {
    _id : string,
    Customer : string;
    Table : string;
    Dishes : string[];
    // details : [
    //     {
    //         name : string,
    //         quantity : string
    //     }
    // ];
    Bill : number;
}

export interface customerviewmodel 
{
    _id : string;
    category: string;
    food_name : string;
    quant : string;
    price : string;
}

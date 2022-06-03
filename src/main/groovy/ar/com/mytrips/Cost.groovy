package ar.com.mytrips

class Cost {

    Currency currency
    double amount

    static constraints = {
        currency nullable: true
        amount nullable: true
    }

    Cost plus(Cost cost){
        if(currency != cost.currency){
            throw ServiceException.invalidCurrency([extected: currency, actual: cost.currency ]).badRequest
        }
        new Cost(currency: currency, amount: amount + cost.amount)
    }

    Map<Currency, Cost> accumulate(Map<Currency, Cost> accu){
        if(accu.containsKey(currency)){
            accu[currency] = plus(accu[currency])
        }else{
            accu[currency] = this
        }
        return accu
    }

}

enum Currency {
    ARS,
    UYU,
    USD,
    EUR,
    CLP,
    BRL,
    PYG,
    VEF,
    BOB,
    COP,
    MXN,
    PEN;
}
package com.andryanstgkr.parsamosir.api.predicate;

import com.andryanstgkr.parsamosir.api.model.admin.Village;

public class KelurahanPredicate implements BasePredicate<Village>{

    @Override
    public boolean test(Village v) {
        return v.getType().equals("K");
    }
    
}

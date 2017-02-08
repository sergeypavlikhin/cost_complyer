package com.crystal;

import com.crystal.entities.Cost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey on 07.02.2017.
 */
public class CostComplyer {

    public static void main (String [] args){
        System.out.println("Run tests to test :)");
    }

    public static List<Cost> comply(List<Cost> oldCosts, List<Cost> newCosts){
        List<Cost> result = new ArrayList<Cost>();

        Collections.sort(newCosts);

        for (Cost oCost : oldCosts) {

            for (Cost nCost : newCosts) {
                if(oCost.aboutSameProduct(nCost)){ //product_code, number, depart are equals
                    if(oCost.overlapDates(nCost)){
                        result.addAll(CostMergeUtils.mergeCosts(oCost, nCost));
                    }
                }
            }
            if(oCost.isValidPeriod()){
                result.add(oCost);
            }
        }
        result.addAll(newCosts);
        return result;
    }

}

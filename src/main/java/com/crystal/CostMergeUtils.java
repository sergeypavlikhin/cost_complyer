package com.crystal;

import com.crystal.entities.Cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey on 07.02.2017.
 */
public class CostMergeUtils {

    /**
     * Both costs have same number and department
     * @param oldCost
     * @param newCost
     * @return List &lt;Cost&gt; with merged Costs by rules
     */
    public static List<Cost> mergeCosts(Cost oldCost, Cost newCost){
        if(oldCost.getValue() == newCost.getValue()){
            return mergeDates(oldCost, newCost);
        }else{
            return mergeValues(oldCost, newCost);
        }
    }

    private static List<Cost> mergeValues(Cost oldCost, Cost newCost) {
        List<Cost> result = new ArrayList<Cost>();
        Cost reserved = oldCost.clone();

        if(reserved.getBegin().before(newCost.getBegin())){
            reserved.setEnd(newCost.getBegin());
            result.add(reserved);
        }
        oldCost.setBegin(newCost.getEnd());

        return result;
    }

    private static List<Cost> mergeDates(Cost oldCost, Cost newCost) {
        if(newCost.getEnd().before(oldCost.getEnd())){
            newCost.setEnd(oldCost.getEnd());
        }
        if(oldCost.getBegin().before(newCost.getBegin())){
            newCost.setBegin(oldCost.getBegin());
        }
        oldCost.setBegin(oldCost.getEnd());
        return Collections.emptyList(); //Why return empty list? Because method implementation can will be changed
    }

}

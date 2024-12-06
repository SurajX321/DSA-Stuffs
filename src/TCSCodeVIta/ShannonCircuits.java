import java.util.*;
public class ShannonCircuits{
    public static Map<String, int[]> simGateOut(Map<String,String[]> gates, Map<String, int[]> inputs, int numCycles){
        Map<String, int[]> outputs =new HashMap<>();
        for(String gate: gates.keySet()){
            outputs.put(gate, new int[numCycles]);}
        for(int t=0;t<numCycles;t++){
            for(String gate: gates.keySet()){
                String[] operation=gates.get(gate);
                String gateType=operation[0];
                String input1=operation[1];
                String input2=operation[2];
                int val1=inputs.containsKey(input1) ? inputs.get(input1)[t]:outputs.get(input1)[t];
                int val2=inputs.containsKey(input2) ? inputs.get(input2)[t]:outputs.get(input2)[t];
                int result=0;
                switch(gateType){
                    case "AND":
                        result= val1 & val2;
                        break;
                    case "OR":
                        result= val1 | val2;
                        break;
                    case "NAND":
                        result= ~(val1 & val2) & 1;
                        break;
                    case "NOR":
                        result= ~(val1 | val2) & 1;
                        break;
                    case "XOR":
                        result= val1 ^ val2;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown gate Type:"+ gateType);}
                outputs.get(gate)[t]=result;}
        }
        return outputs;
    }
    public static void main(String[] args){
        Map<String, String[]> gates= new HashMap<>();

        Map<String, int[]> inputs= new HashMap<>();
        inputs.put("A", new int[]{0,1,0,1});
        inputs.put("B", new int[]{0,1,1,0});
        gates.put("C", new String[]{"AND","A","B"});
        int numCycles=inputs.get("A").length;
        Map<String, int[]> outputs= simGateOut(gates, inputs, numCycles);
        for(String gate:outputs.keySet()){
            System.out.println("Output of " + gate + ":" );
            System.out.println(Arrays.toString(outputs.get(gate)));
        }
    }
}
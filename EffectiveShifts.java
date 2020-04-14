class EffectiveShifts {
    public String stringShift(String s, int[][] shift) {
        int effectiveshifts=getEffectiveNumberOfShifts(shift);
        StringBuilder builder=new StringBuilder();
        effectiveshifts=effectiveshifts%s.length();
         if (effectiveshifts==0){
            return s;
        }
        else if (effectiveshifts>0){
            effectiveshifts=s.length()-effectiveshifts;        
        }
        else {
             effectiveshifts=Math.abs(effectiveshifts);         
        }
         for (int i=effectiveshifts;i<s.length();i++){
                builder.append(s.charAt(i));
         }
            
         for (int i=0;i<effectiveshifts;i++){
                builder.append(s.charAt(i));
         }
        return builder.toString();
    }
    
    public int getEffectiveNumberOfShifts(int[][] shift){
        int effectiveShifts=0;
        for (int i=0;i<shift.length;i++){
            if (shift[i][0]==0){
                effectiveShifts=effectiveShifts-shift[i][1];
            }
            else {
                effectiveShifts=effectiveShifts+shift[i][1];
            }
        }
        return effectiveShifts;
    }
}

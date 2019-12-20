global class DailyLeadProcessor implements Schedulable{
    global void execute(SchedulableContext sc){
        List<Lead> lstOfLead = [SELECT Id FROM Lead WHERE LeadSource = null LIMIT 200];
        
        List<Lead> lstOfUpdatedLead = new List<Lead>();
        if(!lstOfLead.isEmpty()){
            for(Lead ld : lstOfLead){
                ld.LeadSource = 'Dreamforce';
                lstOfUpdatedLead.add(ld);
            }
            
            UPDATE lstOfUpdatedLead;
        }        
    }
}
var agentOption = {
    valueNames: ['id', 'firstName', 'secondName', 'patronymic', 'address', 'phoneNumber', 'branch-name']
};

var agentList = new List('agent', agentOption);

var insuranceOption = {
    valueNames: ['id', 'name', 'agent-percentage']
};

var typeInstanceList  = new List('insurance-type', insuranceOption);

var branchesOption = {
    valueNames: ['id', 'name', 'address', 'phone-number']
};

var branchOfficeList = new List('branch-office', branchesOption);

var contractOption = {
    valueNames: ['id', 'date', 'sum-insured', 'insured-type', 'tariff-rate', 'agent-surname', 'branch' ]
};
var contractList = new List('contract', contractOption);

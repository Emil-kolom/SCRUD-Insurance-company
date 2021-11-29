var agentOption = {
    valueNames: ['id', 'firstName', 'secondName', 'patronymic', 'address', 'phoneNumber', 'branch-name']
};

var typeInstanceList = new List('agent', agentOption);

var insuranceOption = {
    valueNames: ['id', 'name', 'agent-percentage']
};

var agentList = new List('insurance-type', insuranceOption);

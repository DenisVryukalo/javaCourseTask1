package entities;

public class Client extends BasicPerson {
    private ClientType clientType;
    private String address;
    private String enterpriseName;

    public Client(ClientType type, String name, String address){
        super((type == ClientType.JURISTIC_PERSON)? null: name);
        this.enterpriseName = (type == ClientType.JURISTIC_PERSON)? name: null;
        this.clientType = type;
        this.address = address;
    }

    public String getClientType() {
        return clientType.getValue();
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("клиент - ");
        if(clientType == clientType.JURISTIC_PERSON){
            result.append(this.enterpriseName);
        }
        else{
            System.out.println(getPersonFIO());
        }
        result.append(getClientType());
        return result.toString();
    }
}

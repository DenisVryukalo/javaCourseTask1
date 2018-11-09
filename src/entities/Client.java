package entities;

public class Client extends BasicPerson {
    private ClientType clientType;
    private String address;
    private String enterpriseName;

    public Client(
            ClientType type,
            String name,
            String address
    ){
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

    // Client information output
    public void writeInConsole(){
        if(clientType == clientType.JURISTIC_PERSON){
            System.out.println("клиент - " + enterpriseName);
        }
        else{
            System.out.println("клиент - " + getPersonFIO());
        }
        System.out.println(getClientType());
    }
}

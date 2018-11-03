package entitiesP;

public class Client extends BasicPerson {
    private ClientType clientType;
    private String address;
    private String enterpriseName;


    public ClientType getClientType() {
        return clientType;
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

    public Client(
            String personFIO,
            ClientType clientType,
            String address,
            String enterpriseName
    ){
        super(personFIO);
        this.clientType = ClientType.JURISTIC_PERSON;
        this.address = address;
        this.enterpriseName = enterpriseName;
    }

    public Client(
            String personFIO,
            String address
    ){
        super(personFIO);
        this.clientType = ClientType.PRIVATE_PERSON;
        this.address = address;
        this.enterpriseName = "";

    }

}

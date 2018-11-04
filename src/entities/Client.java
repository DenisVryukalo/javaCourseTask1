package entities;

public class Client extends BasicPerson {
    //fields---------------------------------------------------------------------------
    private ClientType clientType;
    private String address;
    private String enterpriseName;

    //constructors for private and juristic persons------------------------------------
    public Client(
            String personFIO,
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

    //getters & setters--------------------------------------------------------------
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

    // Вывод информации о клиенте в консоль
    public void writeInConsole(){
        System.out.println("клиент - " + getPersonFIO());
        System.out.println(getClientType());
        if(clientType == clientType.JURISTIC_PERSON){
            System.out.println(enterpriseName);
        }
    }
}

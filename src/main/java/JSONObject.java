public class JSONObject {
    private String model;
    private String prompt;
    public JSONObject(String model, String prompt) {
        this.model = model;
        this.prompt = prompt;
    }
    public String getModel() {
        return model;
    }
    public String getPrompt() {
        return prompt;
    }
}

import GitClient from "./GitClient";
import axios from "axios";

jest.mock("axios");

describe("Git Client Tests", () => {

  test("should return repository names for techiesyed", async () => {

    axios.get.mockResolvedValue({
      data: [
        { name: "React-App" },
        { name: "Java-Project" },
        { name: "SpringBoot" }
      ]
    });

    const result = await GitClient.getRepositories("techiesyed");

    expect(result).toEqual([
      "React-App",
      "Java-Project",
      "SpringBoot"
    ]);
  });

});
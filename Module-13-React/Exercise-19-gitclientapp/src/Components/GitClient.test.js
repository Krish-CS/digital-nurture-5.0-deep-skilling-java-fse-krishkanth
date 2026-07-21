import GitClient from './GitClient';
import axios from 'axios';

jest.mock('axios');

describe("Git Client Tests", () => {
    test("should return repository names for techiesyed", async () => {
        const dummyData = [{ name: 'repo1' }, { name: 'repo2' }];
        axios.get.mockResolvedValue({ data: dummyData });

        const client = new GitClient();
        const repos = await client.getRepositories('techiesyed');
        
        expect(repos).toEqual(dummyData);
        expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
    });
});

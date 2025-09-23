import axios from "axios";

const API_BASE = "http://localhost:8080/api/users";

export const loginUser = async (email, password) => {
    try {
        const response = await axios.post(`${API_BASE}/login`,null, {
            params:{email, password}
        })
        return response.data;
    } catch(e){
        console.error(e);
    }
}

export {loginUser};
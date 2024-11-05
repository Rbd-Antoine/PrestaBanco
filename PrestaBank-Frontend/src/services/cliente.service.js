import httpClient from "../http-common";

const getAll = () => {
    console.log("Fetching all clients...");
    return httpClient.get('/api/v1/cliente/')
        .then(response => {
            console.log("Response received:", response.data);
            return response;
        });
}

const create = data => {
    return httpClient.post("/api/v1/cliente/", data);
}

const update = data => {
    return httpClient.put('/api/v1/cliente/', data);
}

const get = id => {
    return httpClient.get(`/api/v1/cliente/${id}`);
}

const getRut = rut => {
    return httpClient.get(`/api/v1/cliente/rut/${rut}`);
}

export default { getAll, create, get, update, getRut};
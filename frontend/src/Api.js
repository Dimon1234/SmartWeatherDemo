import axios from 'axios'

const SERVER_URL = 'http://localhost:8080/weather-api/';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {
    // get weather info
    getInfo: (city, country, state) => instance.post('info', {city: city, country: country, state: state})
}
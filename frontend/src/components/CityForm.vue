<template>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <form @submit="formSubmit">
                            <strong>City</strong>
                            <input type="text" class="form-control" v-model="city">
                            <strong>Country</strong>
                            <input type="text" class="form-control" v-model="country">
                            <strong>State</strong>
                            <input type="text" class="form-control" v-model="state">
                            <p></p>
                            <button class="btn btn-success">Submit</button>
                        </form>
                        <strong>Output:</strong>
                        <pre id="weatherText">
                        {{weather}}
                        </pre>
                        <pre id="adviceText">
                       {{advice}}
                        </pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import api from '../Api';

    export default {
        mounted() {
            console.log('Component mounted.')
        },
        data() {
            return {
                city: '',
                country: '',
                state: '',
                advice: '',
                weather: ''
            };
        },
        methods: {
            formSubmit(e) {
                e.preventDefault();
                let currentObj = this;
                api.getInfo(this.city, this.country, this.state)
                    .then(function (response) {
                        currentObj.weather = "Current weather is: " + response.data.weather;
                        currentObj.advice = response.data.advice == null ? "" : "Smart advice: " + response.data.advice;
                    })
                    .catch(function (error) {
                        currentObj.weather = error.response.data.message;
                        currentObj.advice = ""
                    });
            }
        }
    }
</script>

<style scoped>
    #adviceText {
        margin-left: 0%;
    }

    #weatherText {
        margin-left: 0%;
    }
</style>

### Sample Pact consumer service

The sample Pact consumer service based on Spring Boot with contract testing GitHub Actions CI/CD pipeline.

This repository implements the contract testing pipeline following [the general documentation](https://docs.pact.io/pact_nirvana/step_4/#consumer-pipeline).
![asd](https://docs.pact.io/assets/images/advanced-pact-workshop-diagrams-consumer-pipeline-b67d7ab46fe4bdc62e8103e86b9c55d8.png)

On merge to any branch it triggers [the GitHub Actions pipeline](https://github.com/artemptushkin/jesse-pinkman-pact-service/actions)
that includes steps:
1. build
2. tests
3. verify pacts as provider
4. can-i-deploy
5. dummy deploy
6. create-version-tag

### Tags strategy

1. It publishes tag equal to an environment after the actual deployment to that env: `test, prod`
2. It publishes pacts along with tags: (it differs from the provider set of tags!) 
* locally: `develop`
* CI: `{GIT_BRANCH}`
* CD pipeline: `master, test, prod`
3. It uses version
* locally: from maven
* CI/CD pipeline: first 6 letters of a git commit hash
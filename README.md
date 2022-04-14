# JECC: Java Elliptic Curve Cryptography

###### A Java implementation of public-key asymmetric Elliptic Curve Cryptography point arithmetic to facilitate Eliptic Curve Deffie-Hellmann key exchange, and to issue and verify digital signatures using ECDSA.

![Status](https://img.shields.io/github/last-commit/mohamedelghamrawy/jecc)
![Release](https://img.shields.io/badge/Release-Beta-orange)
![License](https://img.shields.io/badge/License-GPLv3-brightgreen.svg)
![UserGuide](https://img.shields.io/badge/User_Guide-Wiki-orange.svg)

## Beta Release
As this project is still in beta, there is no intention to make future release backwards compatible.

## Implemented Elliptic Curves
Currently, only the secp256k1 curve is implemented.

## Instructions
To compute a scalar point multiplication, invoke the scalarMultiply method found within the EcPointArithmetic class.

## Testing
The project is extensively tested using automatically generated test vectors from the BouncyCastle library. 

## Requests/Recommendations
If you have feature requests or project recommendations, please feel free to reach out and ask.
Also feel free to reach out if you would like to contribute.

## Future Improvements
- Implement ECDSA
- Increase number of supported curves

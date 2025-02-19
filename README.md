# NovaNotes - Secure Note-Taking App

## Overview
NovaNotes is a privacy-focused encrypted note-taking application for Android that enables secure synchronization through Proton Drive.

## Project Description
NovaNotes combines robust security features with a seamless user experience, prioritizing user privacy while maintaining functionality. The app serves both as a practical tool for secure note-taking and as a learning project in secure mobile development.

## Core Objectives
- Build a secure and functional note-taking application
- Implement end-to-end encryption
- Provide secure synchronization capabilities
- Maintain a smooth user experience
- Serve as a learning project for secure mobile development

## Target Audience
- Privacy-conscious users
- Individuals requiring secure note storage
- Users seeking a private alternative to mainstream note apps

## Security Features

### End-to-End Encryption
- AES-256 encryption for all notes
- SQLCipher encrypted database implementation
- EncryptedSharedPreferences for secure preferences storage

### Robust Authentication
- Biometric authentication support
- TOTP-standard 2FA implementation
- Compatibility with open-source authenticators (Aegis)
- Configurable automatic locking

### Secure Synchronization
- Certificate Pinning for connections
- File integrity verification
- Encrypted differential synchronization
- Secure connection handling

### Data Protection
- Incognito mode
- Optional root detection
- Memory sanitization
- Screenshot prevention
- Secret container with separate authentication

## General Features

### User Interface
- Modern Material Design 3 implementation
- Automatic light/dark theme switching
- Intuitive navigation and controls

### Organization
- Folder-based organization
- Tag support
- Advanced search capabilities
- Hierarchical note structure

### Backup & Export
- Secure note export functionality
- Automated encrypted backups
- Complete offline mode support
- Encrypted backup verification

### Synchronization
- Proton Drive integration
- Differential sync to minimize data transfer
- Conflict resolution handling
- Offline changes queue

## Technical Specifications
The application implements industry-standard security practices and modern Android development patterns:

- Encryption: AES-256
- Database: SQLCipher
- Authentication: Biometric + TOTP 2FA
- UI Framework: Material Design 3
- Minimum Android Version: [To be determined]

## Development Focus
- Clean Architecture principles
- Comprehensive security testing
- Regular security audits
- Performance optimization
- Battery efficiency
- Minimal permission requirements

## Future Enhancements
- Multiple account support
- Advanced export options
- Additional sync providers
- Enhanced search capabilities
- Collaboration features (while maintaining E2EE)

---

This document outlines the initial scope and features of the NovaNotes project. As development progresses, this documentation will be updated to reflect changes and improvements.
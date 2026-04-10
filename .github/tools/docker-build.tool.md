---
name: Docker Build
description: Tool for building and managing Docker images
type: terminal
command-prefix: docker
---

# Docker Build Tool

## Purpose

Build, run, and manage Docker images for the **directory-backend** microservice.

## Available Commands

### Build

```bash
# Build image
docker build -t directory-backend:latest .

# Build with specific tag
docker build -t directory-backend:0.0.1 .

# Build with no cache
docker build --no-cache -t directory-backend:latest .
```

### Run

```bash
# Run container
docker run -p 8080:8080 --env-file default.env directory-backend:latest

# Run in background
docker run -d -p 8080:8080 --env-file default.env --name directory-backend directory-backend:latest

# View logs
docker logs -f directory-backend
```

### Inspect

```bash
# List images
docker images | grep directory-backend

# Image history (layer sizes)
docker history directory-backend:latest

# Inspect image
docker inspect directory-backend:latest
```

### Clean

```bash
# Stop and remove container
docker stop directory-backend && docker rm directory-backend

# Remove image
docker rmi directory-backend:latest

# Prune unused images
docker image prune -f
```

## Notes

- Use `default.env` as template for environment variables (never commit real secrets).
- Ensure JDK 21 base image is used.
- Multi-stage build recommended for smaller images.

---
name: GitHub CLI
description: Tool for GitHub operations via the gh CLI
type: terminal
command-prefix: gh
---

# GitHub CLI Tool

## Purpose

Manage GitHub issues, pull requests, and releases for the **directory-backend** repository.

## Available Commands

### Issues

```bash
# List open issues
gh issue list --state open

# Create issue
gh issue create --title "Title" --body "Description" --label "bug"

# View issue
gh issue view 42

# Close issue
gh issue close 42
```

### Pull Requests

```bash
# List PRs
gh pr list

# Create PR
gh pr create --title "Feature: ..." --body "Description" --base main

# View PR status
gh pr status

# Review PR
gh pr review 42 --approve

# Merge PR
gh pr merge 42 --merge
```

### Releases

```bash
# Create release
gh release create v0.0.1 --title "v0.0.1" --notes "Release notes"

# List releases
gh release list

# Upload asset
gh release upload v0.0.1 target/directory-backend.jar
```

### Workflows

```bash
# List workflow runs
gh run list

# View run details
gh run view <run-id>

# Re-run failed workflow
gh run rerun <run-id>

# Watch running workflow
gh run watch <run-id>
```

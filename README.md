# ClassicSurvivalMechanics
Minecraft Bukkit/Spigot plugin which makes survival food mechanics work like they did prior to Beta 1.8.

## Usage
Just place in your Spigot server's plugins folder. That's it!

Current version is for: **1.13.2**

## Features
* Hunger never decreases.
* Health never auto-regenerates from a filled hunger bar.
* Food is eaten instantly.
* Food heals you directly.
* Food is not stackable.
* Food healing values all configurable.

## Commands
**CsmReloadConfig**:

Description: Reloads ClassicSurvivalMechanics' config file.

Usage: /CsmReload

Permission: csm.op

**CsmSetHealth**:

Description: Sets the target player's health.

Usage: /SetHealth \<Target\> \<Value\>
  
Permission: csm.op

## Permissions
* csm.*
* csm.op

## Known Issues
* Chorus fruit will not teleport you when eaten through this plugin. You will still be teleported if you have a full health bar and eat it normally.
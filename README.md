# Repo will be renamed soon

# InstaMine

InstaMine is a minecraft plugin that enables insta mining for
any block thanks to a requirement system.

Deepslate is supported by default.

## Available Requirements

### Item Type

Set the required item to break the block.

```yml
- ==: com.github.kaspiandev.instamine.requirement.ItemTypeRequirement
  type: ITEM_TYPE
  material: NETHERITE_PICKAXE
```

### Enchantment

Set the required enchantment type and level.

```yml
- ==: com.github.kaspiandev.instamine.requirement.EnchantmentRequirement
  type: ENCHANTMENT
  level: 5
  enchantment: efficiency
```

### Model Data

Set the required model data. Useful for things like custom tools.

```yml
- ==: com.github.kaspiandev.instamine.requirement.ModelDataRequirement
  type: MODEL
  model: 1
```

### Player Effect

Set the required effect type and amplifier that the player needs to have.

```yml
- ==: com.github.kaspiandev.instamine.requirement.EffectRequirement
  type: EFFECT
  amplifier: 1
  effect: haste
```

### Permission

Set the permission player needs to have.

```yml
- ==: com.github.kaspiandev.instamine.requirement.PermissionRequirement
  type: PERMISSION
  permission: "instamine.obsidian"
```

## Example configuration

```yml
blocks:
  DEEPSLATE:
    - ==: com.github.kaspiandev.instadeepslate.requirement.ItemTypeRequirement
      type: ITEM_TYPE
      material: NETHERITE_PICKAXE
    - ==: com.github.kaspiandev.instadeepslate.requirement.EnchantmentRequirement
      type: ENCHANTMENT
      level: 5
      enchantment: efficiency
    - ==: com.github.kaspiandev.instadeepslate.requirement.EffectRequirement
      type: EFFECT
      amplifier: 1
      effect: haste
  OBSIDIAN:
    - ==: com.github.kaspiandev.instadeepslate.requirement.ItemTypeRequirement
      type: ITEM_TYPE
      material: NETHERITE_PICKAXE
    - ==: com.github.kaspiandev.instamine.requirement.ModelDataRequirement
      type: MODEL
      model: 10
```

## Using InstaMine as dependency

Add jitpack repository to your project.

Gradle:

```groovy
maven { url = "https://jitpack.io" }
```

Maven:

```xml

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Add the plugin as dependency.

Gradle:

```groovy
compileOnly "com.github.KaspianDev:InstaMine:master-SNAPSHOT"
```

Maven:

```xml

<dependency>
    <groupId>com.github.KaspianDev</groupId>
    <artifactId>InstaMine</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

Add the plugin to `depend` or `softdepend` in `plugin.yml`.

```yml
depend: [ InstaMine ]
```

The API currently only contains 2 events:

- `BlockPreInstaMineEvent` - Triggers when all requirements are validated successfully.  
  Cancelling it will stop the insta mining from triggering.
- `BlockInstaMineEvent` - Triggers when the event above wasn't cancelled.

## Building:

```sh
git clone https://github.com/KaspianDev/InstaDeepslate.git
```

```sh
./gradlew build
```

Artifact will be located in build/libs.
